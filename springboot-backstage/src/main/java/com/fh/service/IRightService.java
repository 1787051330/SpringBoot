package com.fh.service;

import com.fh.bean.po.RightBeanPo;

public interface IRightService {
    RightBeanPo addRight(RightBeanPo rightBeanPo);

    RightBeanPo queryRightById(Integer rightId);
}
