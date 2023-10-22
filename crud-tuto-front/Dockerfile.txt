# Étape 1 : Build de l'application Angular
FROM node:14 as builder

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers de configuration de votre application (par exemple, package.json, angular.json)
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier tous les fichiers de votre application Angular dans le conteneur
COPY . .

# Compiler l'application Angular en mode de production
RUN npm run build -- --prod

# Étape 2 : Créer une image légère Nginx pour servir l'application
FROM nginx:1.21

# Copier les fichiers de l'étape précédente (étape 1)
COPY --from=builder /app/dist /usr/share/nginx/html

# Exposer le port 80 pour que l'application Angular puisse être accessible
EXPOSE 80

# Commande pour démarrer le serveur Nginx
CMD ["nginx", "-g", "daemon off;"]
