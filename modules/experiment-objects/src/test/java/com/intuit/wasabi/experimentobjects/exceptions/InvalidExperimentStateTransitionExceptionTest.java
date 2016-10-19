/*******************************************************************************
 * Copyright 2016 Intuit
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
 *******************************************************************************/
package com.intuit.wasabi.experimentobjects.exceptions;

import org.hamcrest.core.Is;
import org.junit.Test;

import static com.intuit.wasabi.experimentobjects.exceptions.ErrorCode.INVALID_EXPERIMENT_STATE;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class InvalidExperimentStateTransitionExceptionTest {

    @Test
    public void testWithMessage() {
        InvalidExperimentStateException e = new InvalidExperimentStateException("e1");

        assertThat(e.getErrorCode(), is(INVALID_EXPERIMENT_STATE));
        assertThat(e.getDetailMessage(), is("e1"));
        assertThat(e.getCause(), is(nullValue()));
    }

    @Test
    public void testWithMessageAndException() {
        Exception r = new RuntimeException("r");
        InvalidExperimentStateException e = new InvalidExperimentStateException("e1", r);

        assertThat(e.getErrorCode(), is(INVALID_EXPERIMENT_STATE));
        assertThat(e.getDetailMessage(), is("e1"));
        assertThat(e.getCause(), Is.is(r));
    }
}
