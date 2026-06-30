# 💬 MultiThreaded Chat Application

A Java console-based **Multithreaded Chat Application** built using **Java Socket Programming**. This project demonstrates real-time communication between multiple clients connected to a server using multithreading.

## 📌 Project Overview

The application follows a **client-server architecture** where:

- A server listens for incoming client connections.
- Multiple clients can connect simultaneously.
- Each client runs on a separate thread.
- Messages sent by one client are broadcast to all other connected clients in real time.

This project demonstrates the practical implementation of:
- Java Networking
- Socket Programming
- Multithreading
- Client-Server Communication

---

## ✨ Features

- ✅ Multiple client support
- ✅ Real-time message broadcasting
- ✅ Java Socket Programming
- ✅ Multithreading using `Runnable`
- ✅ Join and disconnect notifications
- ✅ Console-based interface
- ✅ Lightweight and easy to understand

---

## 🛠 Technologies Used

- Java
- Java Sockets (`java.net`)
- Multithreading
- I/O Streams
- VS Code / IntelliJ / Eclipse

---

## 📂 Project Structure

```
MultiThreadedChatApplication/
│
├── src/
│   ├── ChatServer.java
│   ├── ClientHandler.java
│   └── ChatClient.java
│
├── .gitignore
└── README.md
```

---

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/merajansari2305/MultiThreadedChatApplication.git
cd MultiThreadedChatApplication
```

### 2. Compile the Project

```bash
javac src/*.java
```

### 3. Start the Server

```bash
java -cp src ChatServer
```

Expected Output:

```
=================================
 Java MultiThreaded Chat Server
=================================
Server Started...
Waiting for clients...
Listening on Port : 5555
```

### 4. Start the First Client

Open a new terminal and run:

```bash
java -cp src ChatClient
```

Enter your username when prompted.

### 5. Start Another Client

Open another terminal and run:

```bash
java -cp src ChatClient
```

Enter a different username and start chatting.

---

## 💻 Example

### Server

```
Server Started...
Waiting for clients...
Listening on Port : 5555
```

### Client 1

```
Connected to Chat Server!
Enter Your Name:
Meraj
```

### Client 2

```
Connected to Chat Server!
Enter Your Name:
Rahul
```

### Chat

```
Meraj: Hello Rahul!

Rahul: Hi Meraj!
```

---

## 📖 Concepts Covered

- Java Networking
- Socket Programming
- Multithreading
- Client-Server Architecture
- BufferedReader
- PrintWriter
- Exception Handling
- Concurrent Programming

---

## 🔮 Future Enhancements

- Private messaging
- Online users list
- Group chat support
- File sharing
- GUI using Java Swing or JavaFX
- Chat history
- User authentication
- Message timestamps

---

## 👨‍💻 Author

**Meraj Ansari**

- GitHub: https://github.com/merajansari2305

---

## 📜 License

This project is developed for educational purposes and internship learning.
