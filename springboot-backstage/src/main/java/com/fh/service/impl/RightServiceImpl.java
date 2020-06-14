package com.fh.service.impl;

import com.fh.bean.po.RightBeanPo;
import com.fh.mapper.IRightMapper;
import com.fh.service.IRightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("rightService")
public class RightServiceImpl implements IRightService {

    @Autowired
    private IRightMapper rightMapper;

    public List<Map<String, Object>> queryRightTree() {
        return rightMapper.queryRightTree();
    }

    @Override
    public RightBeanPo addRight(RightBeanPo rightBeanPo) {
        if(rightBeanPo.getId() != null){
            if(rightBeanPo.getType() == 2){
                rightBeanPo.setPathUrl("");
            }
                rightMapper.updateById(rightBeanPo);


        }else{
            rightBeanPo.setStatus(1);
            rightMapper.insert(rightBeanPo);
        }
        return rightBeanPo;
    }

    @Override
    public RightBeanPo queryRightById(Integer rightId) {
        return rightMapper.selectById(rightId);
    }

}
