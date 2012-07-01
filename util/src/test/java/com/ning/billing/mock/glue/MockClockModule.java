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

package com.ning.billing.mock.glue;

import com.google.inject.AbstractModule;
import com.ning.billing.util.clock.Clock;
import com.ning.billing.util.clock.ClockMock;


public class MockClockModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Clock.class).to(ClockMock.class).asEagerSingleton();
        bind(ClockMock.class).asEagerSingleton();
    }

}
