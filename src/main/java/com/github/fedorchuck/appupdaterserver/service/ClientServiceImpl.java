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

package com.github.fedorchuck.appupdaterserver.service;

import java.util.ArrayList;
import java.util.List;

import com.github.fedorchuck.appupdaterserver.model.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("WeakerAccess")
@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	private static List<Response> responses;
	
	static{
		responses = populateDummyUsers();
	}

	public Response findByToken(String token) {
		for(Response response : responses){
			if(response.getAccessToken().equalsIgnoreCase(token)){
				return response;
			}
		}
		return null;
	}

	public Response getNext(String token) {
		Response currentResponse = findByToken(token);
		int curent = responses.indexOf(currentResponse);
		if (curent < responses.size()-1) {
			curent++;
			return responses.get(curent);
		} else {
			currentResponse.setUrlToUpdate("");
			return currentResponse;
		}
	}

	private static List<Response> populateDummyUsers(){
		List<Response> responses = new ArrayList<>();
		responses.add(new Response("d19455ee-2c96-11e6-b67b-9e71128cae77","0.0.1","some url","OK","link to doc"));
		responses.add(new Response("d1945ce2-2c96-11e6-b67b-9e71128cae77","0.0.2","some url","OK","link to doc"));
		responses.add(new Response("d1945ee0-2c96-11e6-b67b-9e71128cae77","0.0.3","some url","OK","link to doc"));
		responses.add(new Response("d194607a-2c96-11e6-b67b-9e71128cae77","0.0.4","https://www.dropbox.com/s/r3re0nhvkwgbt6z/font-awesome-4.6.2.zip?dl=1","OK","link to doc"));
		return responses;
	}
}
