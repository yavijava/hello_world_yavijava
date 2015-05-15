package com.toastcoders.samples;

import java.net.URL;
import java.util.Calendar;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;

/**
 * Copyright 2015 Michael Rice <michael@michaelrice.org>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Example: java -jar hello_world_yavijava-1.0.jar administrator@vsphere.local password 172.16.214.143");
            System.exit(1);
        }
        // Connection info needed to connect to the vSphere server
        String user = args[0];
        String passwd = args[1];
        // This can be the hostname or ip of the vSphere server
        String host = args[2];

        // the last param of true for ServiceInstance is to ignore SSL
        // Im using true because the default setup most folks use is to have
        // the self signed SSL certs provided during the vSphere install and
        // they have not added those certs to their java keystore.
        // If you do not provide true here the default is false so the cert
        // must be in your keystore, or you will get SSL errors.
        ServiceInstance serviceInstance = new ServiceInstance(new URL("https://" + host + "/sdk"),user, passwd, true);

        // If you make it this far you have connected and have a valid ServiceInstance which can be used to do something.
        // So lets see what time the server thinks it is.
        Calendar calendar = serviceInstance.currentTime();
        System.out.println("Server Time: " + calendar.getTime().toString());

        // Now lets see what our Session ID is
        String session = serviceInstance.getServerConnection().getSessionStr();
        System.out.println("Session: " + session);

        // Now lets log off.
        System.out.println("Logging off.");
        serviceInstance.getServerConnection().logout();
    }
}
