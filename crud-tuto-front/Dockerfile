
FROM node:14 as builder


WORKDIR /app

COPY package*.json ./


RUN npm install

COPY . .


RUN npm run build -- --prod




EXPOSE 80


CMD ["ng", "serve", "--host", "0.0.0.0"]
