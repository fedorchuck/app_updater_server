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

import com.github.fedorchuck.appupdaterserver.model.Response;
import org.junit.Assert;
import org.junit.Test;

public class ClientServiceImplTest {

    @Test
    public void test001() {
        ClientServiceImpl clientServiceImplTest = new ClientServiceImpl();
        Response expected = new Response("d194607a-2c96-11e6-b67b-9e71128cae77","0.0.4","https://www.dropbox.com/s/r3re0nhvkwgbt6z/font-awesome-4.6.2.zip?dl=1","OK","link to doc");
        Assert.assertEquals(expected,clientServiceImplTest.findByToken("d194607a-2c96-11e6-b67b-9e71128cae77"));
    }

    @Test
    public void test002() {
        ClientServiceImpl clientServiceImplTest = new ClientServiceImpl();
        Response expected = new Response("d194607a-2c96-11e6-b67b-9e71128cae77","0.0.4","https://www.dropbox.com/s/r3re0nhvkwgbt6z/font-awesome-4.6.2.zip?dl=1","OK","link to doc");
        Assert.assertEquals(expected,clientServiceImplTest.getNext("d1945ee0-2c96-11e6-b67b-9e71128cae77"));
        expected = new Response("d194607a-2c96-11e6-b67b-9e71128cae77","0.0.4","","OK","link to doc");
        Assert.assertEquals(expected,clientServiceImplTest.getNext("d194607a-2c96-11e6-b67b-9e71128cae77"));
    }
}