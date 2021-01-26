package com.chongaizhen.springcloud.service.impl;

import com.chongaizhen.springcloud.dao.PaymentDao;
import com.chongaizhen.springcloud.entities.Payment;
import com.chongaizhen.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @auther chongaizhen
 * @create 2020-02-18 10:40
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
