# Stage 1: Build the Angular application
FROM node:14 as builder

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json to install dependencies
COPY package*.json ./

# Install Angular CLI globally
RUN npm install -g @angular/cli

# Install project dependencies
RUN npm install

# Copy the application code
COPY . .

# Build the Angular application
RUN ng build --prod

# Stage 2: Create a lightweight Nginx image to serve the Angular application
FROM nginx:1.21

# Copy the built Angular application from the builder stage
COPY --from=builder /app/dist/crudtuto-Front /usr/share/nginx/html

# Expose port 80 for Nginx
EXPOSE 80

# Start Nginx when the container runs
CMD ["nginx", "-g", "daemon off;"]