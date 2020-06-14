package com.fh.service.impl;

import com.fh.bean.po.DeptBeanPo;
import com.fh.mapper.IDeptMapper;
import com.fh.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptMapper deptMapper;

    @Override
    public List<Map<String, Object>> queryDeptTree() {
        List<DeptBeanPo> deptList = deptMapper.selectList(null);
        return getDeptList(deptList,0);
    }

    @Override
    public DeptBeanPo addDept(DeptBeanPo deptBeanPo) {
        deptBeanPo.setStatus(1);
        deptMapper.insert(deptBeanPo);
        return deptBeanPo;
    }

    @Override
    public DeptBeanPo queryDeptId(Integer deptId) {
        return deptMapper.selectById(deptId);
    }

    @Override
    public void deptUpdate(DeptBeanPo deptBeanPo) {
        deptMapper.updateById(deptBeanPo);
    }

    @Override
    public void delDept(Integer deptId) {
        deptMapper.deleteById(deptId);
    }

    public List<Map<String,Object>> getDeptList(List<DeptBeanPo> deptList,Integer pid){
        List<Map<String,Object>> list = new ArrayList<>();
        deptList.forEach(dept->{
            Map<String,Object> map = null;
            if(dept.getPid().equals(pid)){
                map = new HashMap<>();
                map.put("id",dept.getId());
                map.put("name",dept.getDeptName());
                map.put("pid",dept.getPid());
                map.put("children",getDeptList(deptList,dept.getId()));
                if(dept.getPid() == 0){
                    map.put("iconOpen","/static/orgimg/1_open.png");
                    map.put("iconClose","/static/orgimg/organ.png");
                }else{
                    map.put("icon","/static/orgimg/dept2.png");
                }
            }
            if(map != null){
                list.add(map);
            }
        });
        return list;
    }
}
