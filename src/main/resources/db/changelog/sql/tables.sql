CREATE TABLE users
(
    id       INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(255) NOT NULL,
    created  TIMESTAMP
);

CREATE TABLE rooms
(
    id       INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name    VARCHAR(255),
    created TIMESTAMP
);

CREATE TABLE participants
(
    id       INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    roomId        INT NOT NULL,
    participantId INT NOT NULL,
    created       DATE,
    FOREIGN KEY (roomId) REFERENCES rooms (id),
    FOREIGN KEY (participantId) REFERENCES users (id)
);

CREATE TABLE messages
(
    id       INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    content  TEXT,
    senderId INT NOT NULL,
    type     VARCHAR(255),
    roomId   INT NOT NULL,
    created  TIMESTAMP,
    FOREIGN KEY (senderId) REFERENCES users (id),
    FOREIGN KEY (roomId) REFERENCES rooms (id)
);