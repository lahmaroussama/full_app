
FROM node:14.18.1 


WORKDIR /usr/local/app


COPY ./ /usr/local/app/

RUN npm cache clean --force

RUN npm install --legacy-peer-deps


RUN npm run build


FROM nginx:latest


COPY --from=build /usr/local/app/dist/crud-tuto-front /usr/share/nginx/html

EXPOSE 80
