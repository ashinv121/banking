provider "aws" {
  region     = "eu-north-1"
  access_key = var.aws_access_key
  secret_key = var.aws_secret_key
}

variable "aws_access_key" {}
variable "aws_secret_key" {}

# Set the existing VPC ID
variable "existing_vpc_id" {
  default = "vpc-0c9e049ba97ebee48"
}

# Create production EC2 instance
resource "aws_instance" "production-server" {
  ami           = "ami-0989fb15ce71ba39e"
  instance_type = "t3.micro"
  subnet_id     = aws_subnet.public_subnet.id
  key_name      = "ansible"
  vpc_security_group_ids = [aws_security_group.test_server_group.id]
  private_ip    = "172.31.48.38"  # Assign private IP address

  tags = {
    Name = "production-server"
  }
}
