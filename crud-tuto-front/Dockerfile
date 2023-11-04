FROM node as build
WORKDIR /app
COPY package.json ./
RUN npm install --force
COPY . ./
RUN npm run build

# stage 2
FROM nginx:stable-alpine
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80
