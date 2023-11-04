FROM node:14 AS builder

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install the Angular CLI globally
RUN npm install --global --production npm-windows-upgrade

# Clear the npm cache
RUN npm cache clean --force

# Set a more up-to-date npm registry
RUN npm config set registry https://registry.npmjs.org/

# Install project dependencies


# Copy the rest of your application code
COPY . .

# Build your Angular application for production
RUN ng build --prod

# Start a new stage for the final image
FROM nginx:alpine

# Copy the built Angular app to the Nginx HTML directory
COPY --from=builder /app/dist/* /usr/share/nginx/html/

# Expose port 80
EXPOSE 80

# Start Nginx in the foreground
CMD ["nginx", "-g", "daemon off;"]
