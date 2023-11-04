FROM node as build
WORKDIR /app
COPY package.json ./
RUN npm install -g npm@10.2.3
COPY . ./
RUN npm run build

# stage 2
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
