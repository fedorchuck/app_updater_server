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

package com.github.fedorchuck.appupdaterserver.controller;

import com.github.fedorchuck.appupdaterserver.model.Response;
import com.github.fedorchuck.appupdaterserver.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("unused")
@RestController
public class UpdaterRestController {

	@Autowired
	ClientService clientService;

	// /client?token={token}&version={}
	@RequestMapping(value = "/client", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> get(
										@RequestParam("token") String token,
										@RequestParam("version") String version){
		Response response = clientService.findByToken(token);
		if (response == null){
			response = new Response("","","","bad token","doc url");

			System.out.println(token+'\t'+response.toString());
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		response = clientService.getNext(token);

		System.out.println(token+'\t'+response.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
