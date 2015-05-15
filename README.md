# hello_world_yavijava

## Usage

To run this sample you will need at least JAVA 1.6 

Build:

    ./gradlew fatJar

The above command will build a jar file that contains all of the dependencies needed to run the sample. If you are on Windows use the gradlew.bat file

Next:

    java -jar build/libs/hello_world_yavijava-1.0.jar administrator@vsphere.local password 172.16.214.143

This will execute the sample. It will use administrator@vsphere.local as the username, password as the password, it will connect to the host 172.16.214.143 and print the server time, the session id, and then log off. The connection info above is an example. Please use valid values for your environment.

