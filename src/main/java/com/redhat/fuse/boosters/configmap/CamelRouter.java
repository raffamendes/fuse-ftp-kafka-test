/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package com.redhat.fuse.boosters.configmap;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel REST DSL route that implements the greetings service.
 * 
 */

/*
 * 
 * 
 * ip: 190.107.177.159
puerto: 8222
usuario: rmendes
pass: FelipeEuAmoVocetá
 */
@Component
public class CamelRouter extends RouteBuilder {
	

    @Override
    public void configure() throws Exception {

        // @formatter:off
    	from("ftp://{{ftp.server.user}}@{{ftp.server.url}}{{ftp.server.dir}}?autoCreate=false&password={{ftp.server.password}}&passiveMode=true&localWorkDirectory=/tmp&move=finished&moveFailed=error")
    	.to("kafka:{{kafka.topic.name}}?brokers={{kafka.bootstrap.url}}:{{kafka.bootstrap.port}}&maxRequestSize=100000000");
    	
    	from("kafka:test-wom-meta?brokers=10.74.180.213:9092&maxPartitionFetchBytes=100000000&autoOffsetReset=earliest").to("file:/tmp");
    	

        // @formatter:on
    }

}