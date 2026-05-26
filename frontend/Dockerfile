FROM node:18-slim

WORKDIR /app

RUN npm install -g pnpm

# Copy package and lock files
COPY package.json pnpm-lock.yaml* package-lock.json* yarn.lock* ./

# Install dependencies using pnpm
RUN \
  if [ -f pnpm-lock.yaml ]; then pnpm install; \
  elif [ -f package-lock.json ]; then npm ci; \
  elif [ -f yarn.lock ]; then yarn --frozen-lockfile; \
  else npm install; \
  fi

# Copy local code to container
COPY . .

EXPOSE 3000

ENV PORT=3000
ENV HOSTNAME="0.0.0.0"

CMD ["pnpm", "dev"]
