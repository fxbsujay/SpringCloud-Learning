package com.susu.action;

import com.susu.entity.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface OrderTccAction {

    @TwoPhaseBusinessAction(name = "gene-order", commitMethod = "commit", rollbackMethod = "cancel")
    void copy(Order order, @BusinessActionContextParameter(paramName = "id") Integer id);

    boolean commit(BusinessActionContext businessActionContext);

    boolean cancel(BusinessActionContext businessActionContext);
}
