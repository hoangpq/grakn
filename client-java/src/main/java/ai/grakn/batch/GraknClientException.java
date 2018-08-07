/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package ai.grakn.batch;

import javax.ws.rs.core.Response.Status.Family;
import javax.ws.rs.core.Response.StatusType;

/**
 * Exceptions generated by the client
 *
 * @author Domenico Corapi
 */
public class GraknClientException extends Exception {

    private final boolean retriable;

    public GraknClientException(String s) {
        this(s, false);
    }

    public GraknClientException(String s, boolean retriable) {
        super(s);
        this.retriable = retriable;
    }

    public GraknClientException(String s, StatusType statusInfo) {
        this(s, statusInfo.getFamily().equals(Family.SERVER_ERROR));
    }

    public boolean isRetriable() {
        return retriable;
    }
}