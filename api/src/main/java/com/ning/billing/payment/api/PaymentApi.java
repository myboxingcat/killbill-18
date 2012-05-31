/*
 * Copyright 2010-2011 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.payment.api;

import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import com.ning.billing.account.api.Account;
import com.ning.billing.util.callcontext.CallContext;

public interface PaymentApi {

    public void updatePaymentGateway(final String accountKey, final CallContext context)
        throws PaymentApiException;

    public PaymentMethodInfo getPaymentMethod(final String accountKey, final String paymentMethodId)
        throws PaymentApiException;

    public List<PaymentMethodInfo> getPaymentMethods(final String accountKey)
        throws PaymentApiException;

    public String addPaymentMethod(final String accountKey, final PaymentMethodInfo paymentMethod, final CallContext context)
        throws PaymentApiException;

    public PaymentMethodInfo updatePaymentMethod(final String accountKey, final PaymentMethodInfo paymentMethodInfo, final CallContext context)
        throws PaymentApiException;

    public void deletePaymentMethod(final String accountKey, final String paymentMethodId, final CallContext context)
        throws PaymentApiException;

    public PaymentInfoEvent createPayment(final String accountKey, final UUID invoiceId, final CallContext context)
        throws PaymentApiException;
    
    public PaymentInfoEvent createPayment(final Account account, final UUID invoiceId, final CallContext context)
    throws PaymentApiException;
    
    public PaymentInfoEvent createPaymentForPaymentAttempt(final String accountKey, final UUID paymentAttemptId, final CallContext context)
        throws PaymentApiException;

    public PaymentInfoEvent createRefund(final Account account, final UUID paymentId, final CallContext context)
        throws PaymentApiException;

    public PaymentProviderAccount getPaymentProviderAccount(final String accountKey)
        throws PaymentApiException;

    public String createPaymentProviderAccount(final Account account, final CallContext context)
        throws PaymentApiException;

    public void updatePaymentProviderAccountContact(final String accountKey, final CallContext context)
        throws PaymentApiException;

    public PaymentAttempt getPaymentAttemptForPaymentId(final UUID id)
        throws PaymentApiException;

    public List<PaymentInfoEvent> getPaymentInfo(final List<UUID> invoiceIds)
        throws PaymentApiException;

    public PaymentInfoEvent getLastPaymentInfo(final List<UUID> invoiceIds)
    throws PaymentApiException;

    public List<PaymentAttempt> getPaymentAttemptsForInvoiceId(final UUID invoiceId)
        throws PaymentApiException;

    public PaymentInfoEvent getPaymentInfoForPaymentAttemptId(final UUID paymentAttemptId)
        throws PaymentApiException;

    public UUID getPaymentAttemptIdFromPaymentId(final UUID paymentId) throws PaymentApiException;
}
