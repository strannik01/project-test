# project-test

Para iniciar la aplicación se deben cargar los valores desde en el archivo src/main/resources/config.properties <br>

#Este es un archivo de configuración para iniciar la aplicación

data.storage=file<br>
data.typelog=3<br>
data.message=Hello World, esta es una prueba<br>
data.path=./v1.0.0<br>

# En data.storage
# file, indica que se creará archivo
# console, indica que se escribirá en consola
# En data.typelog
# 1, es message; 2 es warning; y 3 es error

# Al levantar docker, la imagen se creará como sigue:
# sudo docker build -f Dockerfile -t project-test .
# sudo docker images
# sudo docker run -p 8085:8085 project-test
