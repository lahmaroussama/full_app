
FROM node:14 as builder


WORKDIR /src/app


COPY package*.json ./


RUN npm install


COPY . .


RUN npm run build


FROM nginx:latest


COPY --from=builder /src/app/dist /usr/share/nginx/html


EXPOSE 80