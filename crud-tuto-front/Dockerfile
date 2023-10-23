# Étape 1 : Construction de l'application Angular
FROM node:14.18.1 AS build

WORKDIR /usr/local/app

COPY ./ /usr/local/app/

RUN npm cache clean --force
RUN npm install --legacy-peer-deps
RUN npm run build

# Étape 2 : Configuration du serveur Nginx
FROM nginx:alpine

# Copiez les fichiers construits de l'étape de construction précédente
COPY --from=build /usr/local/app/dist/crud-tuto-front /usr/share/nginx/html

# Exposez le port 80 pour le serveur Nginx
EXPOSE 80
