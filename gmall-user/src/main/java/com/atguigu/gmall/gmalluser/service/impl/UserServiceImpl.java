package com.atguigu.gmall.gmalluser.service.impl;

import com.atguigu.gmall.gmalluser.bean.UmsMember;
import com.atguigu.gmall.gmalluser.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.gmalluser.mapper.UmsReceiveAddressMapper;
import com.atguigu.gmall.gmalluser.mapper.UserMapper;
import com.atguigu.gmall.gmalluser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsReceiveAddressMapper umsReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> list= userMapper.selectAll();//userMapper.selectAllUser();
        return list;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
        umsMemberReceiveAddress.setMemberId(memberId);
        List<UmsMemberReceiveAddress> addressList = umsReceiveAddressMapper.select(umsMemberReceiveAddress);
        return addressList;
    }

    @Override
    public int deleteUserById(String id) {
        UmsMember umsMember=new UmsMember();
        umsMember.setId(id);
        int delete = userMapper.delete(umsMember);
        return delete;
    }

    @Override
    public int updateUserById(String id) {
        UmsMember umsMember=new UmsMember();
        umsMember.setId(id);
        umsMember.setNickname("dashuai");
        int update = userMapper.updateByPrimaryKey(umsMember);
        return update;
    }
    //正确的更新方法——按对象更新
    @Override
    public int updateUser(UmsMember umsMember) {
        UmsMember ums=new UmsMember();
        ums.setNickname(umsMember.getNickname());
        ums.setCity(umsMember.getCity());
        ums.setId(umsMember.getId());
        //...省略了一些setter()
        int update=userMapper.updateByPrimaryKeySelective(ums);//通过ums里面的主键找到位置更新，
        // sql为：UPDATE ums_member SET id = id,nickname = ?,city = ? WHERE id = ?
        return update;
    }
}
