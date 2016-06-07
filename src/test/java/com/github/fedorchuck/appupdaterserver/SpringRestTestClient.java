/*
 * Copyright [2016] [Volodymyr Fedorchuk <vl.fedorchuck@gmail.com>]
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

package com.github.fedorchuck.appupdaterserver;

import com.github.fedorchuck.appupdaterserver.model.Response;
import org.springframework.web.client.RestTemplate;

public class SpringRestTestClient {

	private static final String REST_SERVICE_URI = "http://localhost:8080/client";

	/* GET */
	private static void getUser(){
		System.out.println("Testing get API----------");
		RestTemplate restTemplate = new RestTemplate();
        Response response = restTemplate.getForObject(REST_SERVICE_URI+"?token=d1945ee0-2c96-11e6-b67b-9e71128cae77&version=0.0.3", Response.class);
        System.out.println(response);
	}
	

    public static void main(String args[]){
		getUser();
    }
}