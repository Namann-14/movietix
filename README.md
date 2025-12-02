<div align="center">

# 🎬 MovieTix

### **Your Ultimate Movie Ticket Booking Experience**

*A modern, full-stack movie ticket booking platform built with microservices architecture*

![Next.js](https://img.shields.io/badge/Next.js_15-000000?style=for-the-badge&logo=next.js&logoColor=white)
![React](https://img.shields.io/badge/React_18-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

 [🛠 Installation](#-installation--setup) · [🤝 Contributing](#-contributing)

</div>

---

<div align="center">



<img width="1266" height="669" alt="movitix land" src="https://github.com/user-attachments/assets/ed4e3ff1-ae92-4b25-b689-7329b50a590e" />



*Landing page showcasing the latest movies and seamless booking experience*

</div>

---

## 👨‍💻 About the Developer

<div align="center">

<img src="https://avatars.githubusercontent.com/Namann-14" width="150" height="150" style="border-radius: 50%;" alt="Naman Nayak"/>

### **Naman Nayak**
#### Full-Stack Developer

*Passionate about building scalable applications and creating exceptional user experiences*

[![Portfolio](https://img.shields.io/badge/Portfolio-namannayak.me-4285F4?style=for-the-badge&logo=google-chrome&logoColor=white)](https://namannayak.me)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/naman-nayak14/)
[![GitHub](https://img.shields.io/badge/GitHub-Follow-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Namann-14)

</div>

---

## 🧠 Features

### 🎯 Core Features
- 🎟️ **Real-time Seat Booking** — Interactive seat selection with live availability
- 🎬 **Movie Catalog** — Browse, search, and filter movies by title, genre, and ratings
- 🏢 **Multi-Theater Support** — View showtimes across multiple theater locations
- 👤 **User Authentication** — Secure JWT-based authentication with role management
- 📊 **Admin Dashboard** — Complete management panel for movies, theaters, and bookings
- 📱 **Booking History** — Track all your past and upcoming movie bookings

### ✨ User Experience
- 🌙 **Dark/Light Mode** — Seamless theme switching with next-themes
- ⚡ **Blazing Fast** — Optimized with Next.js 15 and React Query caching
- 📱 **Fully Responsive** — Beautiful experience on mobile, tablet, and desktop
- 🎨 **Smooth Animations** — Elegant transitions powered by Framer Motion
- 🔔 **Real-time Notifications** — Toast notifications for booking confirmations

### 🔧 Developer Experience
- 🏗️ **Microservices Architecture** — Scalable Spring Boot backend with 8 services
- 🔐 **API Gateway** — Centralized routing and security
- ⚙️ **Config Server** — Externalized configuration management
- 🔍 **Service Discovery** — Eureka-based service registry
- 🐳 **Docker Ready** — Containerized deployment with Docker Compose
- 📖 **Type Safety** — End-to-end TypeScript with Zod validation

---

## 📦 Tech Stack

### Frontend
![Next.js](https://img.shields.io/badge/Next.js_15-000000?style=for-the-badge&logo=next.js&logoColor=white)
![React](https://img.shields.io/badge/React_18-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white)
![TanStack Query](https://img.shields.io/badge/TanStack_Query-FF4154?style=for-the-badge&logo=reactquery&logoColor=white)

### Backend
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.4-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL_8-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

### UI & Styling
![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS_4-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white)
![Radix UI](https://img.shields.io/badge/Radix_UI-161618?style=for-the-badge&logo=radixui&logoColor=white)
![Framer Motion](https://img.shields.io/badge/Framer_Motion-0055FF?style=for-the-badge&logo=framer&logoColor=white)
![Lucide](https://img.shields.io/badge/Lucide_Icons-F56565?style=for-the-badge&logo=lucide&logoColor=white)

### DevOps & Tools
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Eureka](https://img.shields.io/badge/Netflix_Eureka-E50914?style=for-the-badge&logo=netflix&logoColor=white)
![pnpm](https://img.shields.io/badge/pnpm-F69220?style=for-the-badge&logo=pnpm&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

---

## 🛠 Installation & Setup

### Prerequisites
- **Node.js** 18+ and **pnpm**
- **Java** 17+
- **MySQL** 8+
- **Maven** 3.8+
- **Docker** (optional, for containerized setup)

### Step 1: Clone the Repository
```bash
git clone https://github.com/Namann-14/movietix.git
cd movietix
```

### Step 2: Set Up the Database
```bash
# Create MySQL database
mysql -u root -p
CREATE DATABASE movietix;
```

### Step 3: Configure Environment Variables
```bash
# Backend - Update application.yml in each service
# Frontend - Create .env.local in /frontend
cp frontend/.env.example frontend/.env.local
```

### Step 4: Start Backend Services
```bash
cd backend

# Option 1: Run all services with Docker
docker-compose up -d

# Option 2: Run manually (start in order)
# 1. Config Server → 2. Eureka Server → 3. Other Services
./run-all.bat  # Windows
```

### Step 5: Start Frontend
```bash
cd frontend
pnpm install
pnpm dev
```

### Step 6: Access the Application
```bash
# Frontend:  http://localhost:3000
# Eureka:    http://localhost:8761
# Gateway:   http://localhost:8080
```

---

## ⚙️ Environment Variables

Create a `.env.local` file in the `/frontend` directory:

```env
# API Configuration
NEXT_PUBLIC_API_URL=http://localhost:8080

# Authentication
NEXT_PUBLIC_JWT_SECRET=your_jwt_secret_key

# Optional: Analytics
NEXT_PUBLIC_VERCEL_ANALYTICS_ID=your_analytics_id
```

Backend services use `application.yml` files in each service's `src/main/resources` directory:

```yaml
# Database Configuration
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/movietix
    username: root
    password: your_password

# JWT Configuration
jwt:
  secret: your_jwt_secret_key
  expiration: 86400000
```

---

## 🧪 Running Tests

```bash
# Frontend Tests
cd frontend
pnpm lint          # Run ESLint
pnpm build         # Build for production (type checking)

# Backend Tests
cd backend
mvn test           # Run all unit tests
mvn verify         # Run integration tests
```

---

## 🧗‍♂️ Folder Structure

```
📦 movietix
├── 📂 frontend/                    # Next.js 15 Frontend
│   ├── 📂 app/                     # App Router pages
│   │   ├── 📂 (admin)/             # Admin dashboard routes
│   │   ├── 📂 (auth)/              # Authentication routes
│   │   ├── 📂 (customer)/          # Customer routes
│   │   └── 📂 browse/              # Movie browsing
│   ├── 📂 components/              # React components
│   │   ├── 📂 admin/               # Admin-specific components
│   │   └── 📂 ui/                  # Reusable UI components
│   ├── 📂 contexts/                # React Context providers
│   ├── 📂 hooks/                   # Custom React hooks
│   ├── 📂 lib/                     # Utilities & API clients
│   └── 📂 public/                  # Static assets
│
├── 📂 backend/                     # Spring Boot Microservices
│   ├── 📂 api-gateway/             # API Gateway (Port 8080)
│   ├── 📂 config-server/           # Configuration Server
│   ├── 📂 eureka-server/           # Service Discovery (Port 8761)
│   ├── 📂 user-service/            # User & Auth Management
│   ├── 📂 movie-service/           # Movie Catalog
│   ├── 📂 theater-service/         # Theater Management
│   ├── 📂 showtime-service/        # Showtime Scheduling
│   ├── 📂 booking-service/         # Booking & Reservations
│   └── 📄 docker-compose.yml       # Docker orchestration
│
└── 📄 README.md                    # You are here! 👋
```

---

## 🛣 Roadmap

### ✅ Completed
- [x] User authentication with JWT
- [x] Movie catalog with search & filters
- [x] Real-time seat selection
- [x] Booking management system
- [x] Admin dashboard
- [x] Responsive design
- [x] Dark/Light mode

### 🚧 In Progress
- [ ] Payment gateway integration (Stripe/Razorpay)
- [ ] Email notifications for bookings
- [ ] QR code ticket generation

### 🔮 Future Plans
- [ ] Mobile app (React Native)
- [ ] Movie reviews & ratings system
- [ ] Social login (Google, GitHub)
- [ ] Recommendation engine
- [ ] Multi-language support (i18n)
- [ ] Advanced analytics dashboard

---

## 🤝 Contributing

Contributions are what make the open-source community amazing! Any contributions you make are **greatly appreciated**.

### Step 1: Fork the Project
Click the **Fork** button at the top right of this page.

### Step 2: Clone Your Fork
```bash
git clone https://github.com/your-username/movietix.git
cd movietix
```

### Step 3: Create a Feature Branch
```bash
git checkout -b feature/AmazingFeature
```

### Step 4: Make Your Changes
Implement your feature or fix.

### Step 5: Commit Your Changes
```bash
git add .
git commit -m "feat: Add AmazingFeature"
```

### Step 6: Push and Create PR
```bash
git push origin feature/AmazingFeature
```
Then open a Pull Request on GitHub!

---

## ⭐ Support

If you found this project helpful, please consider giving it a star! It helps others discover the project and motivates further development.

<div align="center">

[![Star this repo](https://img.shields.io/badge/⭐_Star_this_repo-yellow?style=for-the-badge)](https://github.com/Namann-14/movietix)
[![Fork this repo](https://img.shields.io/badge/🍴_Fork_this_repo-blue?style=for-the-badge)](https://github.com/Namann-14/movietix/fork)

</div>

---

## 📝 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2025 Naman Nayak

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

<div align="center">

### Made with ❤️ by Naman Nayak

[![Portfolio](https://img.shields.io/badge/Portfolio-namannayak.me-4285F4?style=for-the-badge&logo=google-chrome&logoColor=white)](https://namannayak.me)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Let's_Connect-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/naman-nayak14/)

---

#### 💼 Open to Opportunities

*I'm actively looking for full-stack developer roles! If you're a recruiter or hiring manager, I'd love to connect and discuss how I can contribute to your team.*

---

**If you like this project, don't forget to give it a ⭐!**

</div>
