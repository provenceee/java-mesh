/*
 * Copyright (C) 2024-2024 Sermant Authors. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package io.sermant.flowcontrol.common.xds.retry.condition;

import io.sermant.flowcontrol.common.handler.retry.Retry;
import io.sermant.flowcontrol.common.util.XdsThreadLocalUtil;

/**
 * Retry condition check, determine if the current error is a connection reset error before the request, and trigger a
 * retry if it is.
 *
 * @author zhp
 * @since 2024-11-29
 */
public class ResetBeforeRequestErrorCondition extends ResetErrorCondition {
    @Override
    public boolean needRetry(Retry retry, Throwable ex, String statusCode, Object result) {
        return XdsThreadLocalUtil.getSendByteFlag() && super.needRetry(retry, ex, statusCode, result);
    }
}
