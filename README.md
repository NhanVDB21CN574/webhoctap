Website đơn giản dạng blog học Tiếng Anh 
Admin có thể thêm sửa xóa một bài học. Mỗi bài học bao gồm một bài đọc, các câu hỏi trắc nghiệm đi kèm đáp án, các từ vựng đặc biệt trong bài để người dùng có thể học và ôn tập các từ vựng này bằng flashcard và các dạng câu hỏi trắc nghiệm.
User tham gia các bài học có trên trang web. 

Được xây dựng bằng Jsp/Servlet, JDBC kết nối với SqlServer.
•	IDE: Apache NetBeans 13
•	Apache Tomcat 9.0.55
•	JDK 1.8
•	Hệ quản trị cơ sở dữ liệu: SQL Server – Sử dụng công cụ Microsoft sql server management studio 18.
Một số thư viện đi kèm trong thư mục lib
![image](https://github.com/NhanVDB21CN574/webhoctap/assets/91905987/79fed21c-5075-44bd-806f-a0fc59bc622f)

Các bước chạy project:
1. Tải toàn bộ code về.
2.	Open project webhoctap bằng Netbeans.
3.	Vào properties của project cấu hình lại phiên bản jdk và Tomcat theo yêu cầu. 
4.	Import file db.bacpac bằng Microsoft sql server management studio 18. Khi import đặt tên database mới là WEBHOCTAP.
5.	![image](https://github.com/NhanVDB21CN574/webhoctap/assets/91905987/2f270e35-0f92-4daf-a94b-181331a151bf)
6.	![image](https://github.com/NhanVDB21CN574/webhoctap/assets/91905987/741ccff1-5ff0-4981-854a-e7ffdb319a28)
7.	Mở Class DBConnect trong package dao trong project, thay đổi thông tin port, databaseName, username, password tương ứng trong Microsoft sql server management studio 18.
8.	Run project.
9.	Tài khoản, mật khẩu admin :  user1 pass1.
