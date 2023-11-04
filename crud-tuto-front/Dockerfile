FROM node:14 AS builder
WORKDIR /app
COPY package*.json ./
RUN npm install -g @angular/cli
RUN npm cache clean --force
RUN npm config set registry https://registry.npmjs.org/
RUN npm install

COPY . .
RUN ng build --prod
FROM nginx:alpine
COPY --from=builder /app/dist/* /usr/share/nginx/html/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]