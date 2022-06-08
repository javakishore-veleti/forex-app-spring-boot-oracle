# forex-app-spring-boot-oracle
forex-app-spring-boot-oracle


# Oracle Docker Imaage Creation

```shell

git clone https://github.com/oracle/docker-images

cd docker-images/OracleDatabase/SingleInstance/dockerfiles

./buildContainerImage.sh -v 19.3.0 -e

docker run -d --name oracle -p 1521:1521 -p 5500:5500 oracle/database:19.3.0-ee

```

That will be not successful, until you download the corresponding database version. For the example we need to download 
LINUX.X64_193000_db_home.zip 
from here https://www.oracle.com/database/technologies/oracle19c-linux-downloads.html. After downloading you need to place that file in the directory 19.3.0.

If you build an image with another version, just run it first and it will tell you which file is missing.

After running the command above a new image will be available on your machine.
```shell
oracle/database           19.3.0-ee   afe844d8823f   6.53GB
```
