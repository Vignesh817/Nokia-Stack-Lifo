FROM openjdk:8-jdk
ARG exec_jar
ADD $exec_jar /$exec_jar
ENV jarfile $exec_jar
COPY ca.pem $JAVA_HOME/jre/lib/security
COPY ca-env1.pem $JAVA_HOME/jre/lib/security
COPY ca-env2.pem $JAVA_HOME/jre/lib/security
COPY ca-env3.pem $JAVA_HOME/jre/lib/security
COPY ca-env4.pem $JAVA_HOME/jre/lib/security
COPY ca-dev.pem $JAVA_HOME/jre/lib/security
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias testdbcert -file ca.pem
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias env1dbcert -file ca-env1.pem
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias env2dbcert -file ca-env2.pem
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias env3dbcert -file ca-env3.pem
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias env4dbcert -file ca-env4.pem
RUN \
   cd $JAVA_HOME/jre/lib/security \
   && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias devdbcert -file ca-dev.pem
CMD java -Xms2G -Xmx2G $JAVA_OPTS -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=logs/iotpublisherdump.txt -jar $jarfile
EXPOSE 8080
