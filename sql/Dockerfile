FROM mcr.microsoft.com/mssql/server:2017-CU27-ubuntu-16.04

# Create app directory
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# Copy initialization scripts
COPY . /usr/src/app

RUN chmod +x /usr/src/app/run-initialization.sh
ENV SA_PASSWORD hthw8u:@y+5]Dp3,
ENV ACCEPT_EULA Y
ENV MSSQL_PID Express

EXPOSE 1433

CMD /bin/bash ./entrypoint.sh