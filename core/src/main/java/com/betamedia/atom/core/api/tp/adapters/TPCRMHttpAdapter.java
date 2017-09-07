package com.betamedia.atom.core.api.tp.adapters;

import com.betamedia.atom.core.api.tp.entities.request.AccountRO;
import com.betamedia.atom.core.api.tp.entities.response.CRMAccountCreate;
import com.betamedia.atom.core.api.tp.entities.response.CRMDeposit;
import com.betamedia.atom.core.api.tp.entities.response.TPCRMResponse;
import com.betamedia.atom.core.environment.tp.EnvironmentDependent;

/**
 * Adapter for TP-CRM-API (doing operation on TP via http protocol, generally used by CRM)
 *
 * @author Maksym Tsybulskyy
 *         Date: 3/21/17.
 */
public interface TPCRMHttpAdapter<T extends EnvironmentDependent> {

    /**
     * Create a new accounts
     *
     * @param accountRO
     * @return
     */
    TPCRMResponse<CRMAccountCreate> create(AccountRO accountRO);

    /**
     * Deposit to account
     *
     * @param accountId
     * @param amount
     * @param displayBrandId
     * @return transactionId inside CRMDeposit object
     */
    TPCRMResponse<CRMDeposit> deposit(String accountId, Double amount, String displayBrandId);
}
