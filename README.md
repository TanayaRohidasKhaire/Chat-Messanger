# Chat Messenger

A Java-based client-server chat application that uses TCP socket programming for communication between a client and server. The project also includes a built-in logging facility that records chat messages with timestamps in a text file.

## Features

* Client-server communication using TCP sockets
* Real-time text message exchange
* Separate client and server applications
* Uses Java `Socket` and `ServerSocket`
* Console-based chat interface
* Timestamp-based message logging
* Chat messages are stored in `ChatLog.txt`
* Simple Java I/O and file handling

## Technologies Used

* Java
* TCP Socket Programming
* Networking
* Java I/O
* File Handling
* Exception Handling

## Project Structure

```text
Chat-Messenger/
│
├── ChatServer.java
├── ChatClient.java
└── README.md
```

When the application is executed, the following file is automatically created:

```text
ChatLog.txt
```

## How It Works

The project follows a client-server communication model.

```text
              TCP Connection
               Port: 2100

┌──────────────────┐
│   Chat Client    │
│                  │
│ Enter Message    │
└────────┬─────────┘
         │
         │ TCP
         ▼
┌──────────────────┐
│   Chat Server    │
│                  │
│ Receive Message  │
│ Send Response    │
└────────┬─────────┘
         │
         │
         ▼
     Chat Client
```

The client connects to the server using `localhost` and port `2100`.

Messages exchanged between the client and server are also recorded in `ChatLog.txt` with the date and time.

## Logging Facility

The logging functionality is directly implemented inside both Java files, so no separate `Logger.java` file is required.

Example log:

```text
[2026-10-08 18:45:10] Client says: Hello
[2026-10-08 18:45:17] Server says: Hello Client
[2026-10-08 18:45:25] Client says: How are you?
[2026-10-08 18:45:32] Server says: I am fine
```

The log file uses append mode, so new messages are added without deleting previous records.

## How to Run

### Step 1: Open the Project

Open the `Chat-Messenger` folder in VS Code.

Make sure these files are present:

```text
ChatServer.java
ChatClient.java
```

### Step 2: Open Terminal

In VS Code, open:

**Terminal → New Terminal**

Make sure the terminal is inside the project folder.

You can check using:

```bash
dir
```

You should see:

```text
ChatServer.java
ChatClient.java
```

### Step 3: Compile the Programs

Run:

```bash
javac ChatServer.java ChatClient.java
```

If there is no error, Java will create:

```text
ChatServer.class
ChatClient.class
```

### Step 4: Start the Server

In the first terminal, run:

```bash
java ChatServer
```

You should see:

```text
Server application is running...
Server is waiting at port 2100
```

The server is now waiting for the client.

### Step 5: Open a Second Terminal

Open another terminal in the **same project folder**.

Do not close the first terminal.

### Step 6: Start the Client

Run:

```bash
java ChatClient
```

You should see:

```text
Client application is running...
Connection is successfull with server
------------------------------------------
--------- Marvellous Chat Client ---------
------------------------------------------
Enter message for Server :
```

The server will show:

```text
Clients request gets accepted successfully
------------------------------------------
--------- Marvellous Chat Server ---------
------------------------------------------
```

### Step 7: Send Messages

Type a message in the client terminal:

```text
Hello Server
```

The server receives:

```text
Client says : Hello Server
```

The server can reply:

```text
Hello Client
```

The client receives:

```text
Server says : Hello Client
```

### Step 8: Check the Log

After messages are exchanged, a file named:

```text
ChatLog.txt
```

will be created in the project folder.

Example:

```text
[2026-10-08 18:45:10] Client says: Hello Server
[2026-10-08 18:45:17] Server says: Hello Client
```

## How to Stop the Chat

On the client, enter:

```text
End
```

The client will end the chat and close the connection.

## Key Concepts

### 1. Socket Programming

`Socket` is used to establish communication between the client and server.

### 2. ServerSocket

`ServerSocket` listens for incoming client connections on port `2100`.

### 3. TCP Communication

TCP provides a reliable connection between the client and server.

### 4. BufferedReader

Used to read messages from the keyboard and network connection.

### 5. PrintStream

Used to send messages thr
