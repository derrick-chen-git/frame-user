FROM java
MAINTAINER derrick

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/user-web-*.jar /frame-user-web.jar

ENTRYPOINT ["sh","-c","java -jar /frame-user-web.jar $PARAMS"]