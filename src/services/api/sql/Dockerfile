FROM mcr.microsoft.com/mssql/server:2017-CU27-ubuntu-16.04

RUN mkdir -p app
WORKDIR app

COPY . .
RUN chmod +x ./db.sh
CMD /bin/bash ./db.sh