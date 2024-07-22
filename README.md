### What is it?

Simple server to connect machines behind NAT
chat
Each machine has Id and name

Typical NAT structure
```mermaid
flowchart LR
    cl1{{PC-1}} --192.168.0.2-->  r1[router]
    cl2{{PC-2}} --192.168.0.3-->  r1
    cl3{{PC-3}} --192.168.0.4-->  r1
    cl4{{PC-4}} --192.168.0.2-->  r2[router]
    cl5{{PC-5}} --192.168.0.3-->  r2
    cl6{{PC-6}} --192.168.0.4-->  r2
    r1 --172.16.0.2-->  r3[router]
    r2 --172.16.0.3-->  r3
    r3 --1.2.3.4-->  net{NETWORK}
    net --1.2.3.5-->  r6[router]
    r6 --172.16.0.2-->  r4[router]
    r6 --172.16.0.3-->  r5[router]
    r4 --192.168.0.2-->  cl7{{PC-7}}
    r4 --192.168.0.3-->  cl8{{PC-8}}
    r4 --192.168.0.4-->  cl9{{PC-9}}
    r5 --192.168.0.2-->  cl10{{PC-10}}
    r5 --192.168.0.3-->  cl11{{PC-11}}
    r5 --192.168.0.4-->  cl12{{PC-12}}
```
`PC-1` can not connect to `PC-9` because, PC-9 does not have static IP

to resolve this issue, one can use external server `S-1` with public IP

```mermaid
flowchart LR
    cl1{{PC-1}} --> net{NETWORK} 
    cl1 -.-> s1((S-1))
    net -->  cl9{{PC-9}} 
    cl9 -.->s1
```

Program flow

```mermaid
sequenceDiagram
    participant C1 as PC-1
    participant S as SERVER
    participant C2 as PC-9
    C1 ->> S: REGISTER, name = Tom
    S ->> C1: REGISTER_ACK, ip = C1_IP, port = C1_PORT
    C2 ->> S: CONNECT, name = Tom
    S ->> C2: CONNECT_ACK, ip = C1_IP, port = C1_PORT
    C2 ->> C1: CONNECT
    destroy C2
```