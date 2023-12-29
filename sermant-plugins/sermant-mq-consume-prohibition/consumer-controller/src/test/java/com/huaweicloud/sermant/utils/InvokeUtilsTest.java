/*
 * Copyright (C) 2023-2023 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaweicloud.sermant.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * InvokeUtils的单元测试
 *
 * @author lilai
 * @since 2023-12-23
 */
public class InvokeUtilsTest {
    /**
     * 测试是Sermant的KafkaConsumerController发起的调用
     */
    @Test
    public void testInvokeBySermant() {
        StackTraceElement[] stackTrace = new StackTraceElement[4];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "subscribe",
                "testFileName2", 2);
        stackTrace[3] = new StackTraceElement("com.huaweicloud.sermant.kafka.controller.KafkaConsumerController",
                "testMethod3", "testFileName3", 3);
        Assert.assertTrue(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }

    /**
     * 测试是Sermant的KafkaConsumerController发起的调用，KafkaConsumer嵌套多次调用
     */
    @Test
    public void testInvokeBySermantWithNestedInvoke() {
        StackTraceElement[] stackTrace = new StackTraceElement[5];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "unsubscribe",
                "testFileName2", 2);
        stackTrace[3] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "subscribe",
                "testFileName3", 3);
        stackTrace[4] = new StackTraceElement("com.huaweicloud.sermant.kafka.controller.KafkaConsumerController",
                "testMethod4", "testFileName4", 4);
        Assert.assertTrue(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }

    /**
     * 测试不是Sermant的KafkaConsumerController发起的调用
     */
    @Test
    public void testNotInvokeBySermant() {
        StackTraceElement[] stackTrace = new StackTraceElement[4];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "subscribe",
                "testFileName2", 2);
        stackTrace[3] = new StackTraceElement("testClass3", "testMethod3", "testFileName3", 3);
        Assert.assertFalse(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }

    /**
     * 测试不是Sermant的KafkaConsumerController发起的调用，KafkaConsumer嵌套多次调用
     */
    @Test
    public void testNotInvokeBySermantWithNestedInvoke() {
        StackTraceElement[] stackTrace = new StackTraceElement[5];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "unsubscribe",
                "testFileName2", 2);
        stackTrace[3] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "subscribe",
                "testFileName3", 3);
        stackTrace[4] = new StackTraceElement("testClass4", "testMethod4", "testFileName4", 4);
        Assert.assertFalse(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }

    /**
     * 测试不是Sermant的KafkaConsumerController发起的调用，KafkaConsumer无上层调用栈
     */
    @Test
    public void testNotInvokeBySermantWithoutInvoker() {
        StackTraceElement[] stackTrace = new StackTraceElement[3];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("org.apache.kafka.clients.consumer.KafkaConsumer", "subscribe",
                "testFileName2", 2);
        Assert.assertFalse(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }

    /**
     * 测试不是Sermant的KafkaConsumerController发起的调用，没有KafkaConsumer的调用栈
     */
    @Test
    public void testNotInvokeBySermantWithoutKafkaInvocation() {
        StackTraceElement[] stackTrace = new StackTraceElement[3];
        stackTrace[0] = new StackTraceElement("testClass0", "testMethod0", "testFileName0", 0);
        stackTrace[1] = new StackTraceElement("testClass1", "testMethod1", "testFileName1", 1);
        stackTrace[2] = new StackTraceElement("testClass2", "subscribe", "testFileName2", 2);
        Assert.assertFalse(InvokeUtils.isKafkaInvokeBySermant(stackTrace));
    }
}