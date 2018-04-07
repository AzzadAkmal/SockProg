#include<stdio.h>
#include<string.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<unistd.h>

int main(int argc, char *argv[])
{
	int socket_desc, client_sock, c, read_size;
	struct sockaddr_in server, client;
	char message[2000];

	socket_desc = socket(AF_INET, SOCK_STREAM, 0);
	if(socket_desc == -1)
	{
		printf("Could not connect");
	}
	puts("Socket created\n")

	server.sin_family = AF_INET;
	server.sin_addr.s_addr = INADDR_ANY;
	server.sin_port = htons(52051);

	if(bind(socket_desc, (struct sockaddr *) &server,sizeof(server))<0)
	{
		perror("Error : bind failed");
	}
	puts("Bind done\n")

	listen(socket_desc, 3);

	puts("Waiting for incoming connections...");
	c = sizeof(struct sockaddr_in);

	client_sock = accept(socket_desc, (struct sockaddr *) &client,(socklen_t*) &c);

		if (client_sock<0)
		{
			perror("Connection Reject");
		}
		puts("Connection Approved");

		read_size = recv(client_sock, message, 2000, 0);
		char s[] = "Assalamualaikum";
		char a[2000];
		strcpy(a, message);
		if(strcasecmp(a,s)==0)
		{
			strcpy(message, "Waalaikumussalam\n");
		}
		else
		{
			strcpy(message, "Are you muslim"\n");
		}
		write(client_sock, message, strlen(message));

		if (read_size==0)
		{
				puts("Client disconnected");
				fflush(stdout);
		}

		else if (read_size ==-1)
		{
			perror("recv failed");
		}

		return 0;
}