FROM java
MAINTAINER derrick

ENV PARAMS=""

ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/dev-web-*.jar /frame-dev-web.jar

ENTRYPOINT ["sh","-c","java -jar /frame-dev-web.jar $PARAMS"]