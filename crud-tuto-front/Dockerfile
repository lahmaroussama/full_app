FROM node:14.21.3-alpine as node
WORKDIR /app
COPY package.json ./
RUN npm install
COPY . ./
RUN npm run build

# stage 2
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
