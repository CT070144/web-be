-- Tạo bảng training_program
CREATE TABLE IF NOT EXISTS training_program (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    duration VARCHAR(50),
    campus VARCHAR(100),
    admission_period VARCHAR(100),
    overview TEXT,
    image_url VARCHAR(500),
    domestic_tuition VARCHAR(100),
    international_tuition VARCHAR(100),
    tuition_notes TEXT,
    requirements TEXT,
    materials TEXT,
    careers TEXT,
    outcomes TEXT,
    is_active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Thêm dữ liệu mẫu
INSERT INTO training_program (
    name, 
    code, 
    duration, 
    campus, 
    admission_period, 
    overview, 
    image_url, 
    domestic_tuition, 
    international_tuition, 
    tuition_notes, 
    requirements, 
    materials, 
    careers, 
    outcomes
) VALUES 
(
    'Trí tuệ nhân tạo',
    '7480107',
    '4 năm',
    'Hà Nội',
    'Mùa thu',
    'Chương trình đào tạo ngành Trí tuệ nhân tạo (TTNT) của Học viện Công nghệ Bưu chính Viễn thông được thiết kế nhằm đào tạo nhân lực trình độ Đại học (Kỹ sư) ngành Trí tuệ nhân tạo trong bối cảnh hội nhập quốc tế và chuyển đổi số. Sinh viên tốt nghiệp được trang bị các kỹ năng nghề nghiệp trong tương lai về Trí tuệ nhân tạo và Khoa học máy tính bao gồm cả chuyên môn, phẩm chất chính trị, đạo đức nghề nghiệp, và kỹ năng mềm.',
    'https://images.unsplash.com/photo-1677442136019-21780ecad995?w=400&h=250&fit=crop',
    '25.000.000 VNĐ/năm',
    '3.000 USD/năm',
    'Học phí có thể thay đổi theo quy định của Bộ Giáo dục và Đào tạo',
    '["Tốt nghiệp THPT hoặc tương đương", "Điểm chuẩn: 24-26 điểm (tùy năm)", "Tổ hợp xét tuyển: A00, A01, D01, D07", "Yêu cầu tiếng Anh: IELTS 5.5 hoặc tương đương", "Sức khỏe tốt, không mắc các bệnh truyền nhiễm"]',
    '["Giáo trình chuyên ngành AI/ML", "Tài liệu thực hành và bài tập", "Phần mềm và công cụ phát triển", "Thư viện số và cơ sở dữ liệu", "Tài liệu tham khảo quốc tế"]',
    '["Chuyên gia AI/ML Engineer", "Data Scientist", "Research Scientist", "AI Product Manager", "Computer Vision Engineer", "NLP Engineer", "Robotics Engineer", "AI Consultant"]',
    '[{"id":"lo1","title":"LO1: Nhận diện được vấn đề và các giải pháp có thể để giải quyết vấn đề liên quan đến trí tuệ nhân tạo.","content":"PI 1.1: Hiểu bài toán và các yêu cầu\\nPI 1.2: Đề xuất và phân tích giải pháp tính toán giải quyết bài toán\\nPI 1.3: Xác định giải pháp phù hợp dựa trên các nguyên lý tính toán để giải quyết bài toán."},{"id":"lo2","title":"LO2: Thiết kế và triển khai các giải pháp trí tuệ nhân tạo hiệu quả.","content":"PI 2.1: Thiết kế thuật toán và mô hình AI\\nPI 2.2: Triển khai và tối ưu hóa giải pháp\\nPI 2.3: Đánh giá hiệu suất và cải thiện mô hình."}]'
),
(
    'An toàn thông tin',
    '7480102',
    '4 năm',
    'Hà Nội',
    'Mùa thu',
    'Chương trình đào tạo ngành An toàn thông tin trang bị cho sinh viên kiến thức chuyên sâu về bảo mật thông tin, an ninh mạng, mật mã học và các kỹ thuật bảo vệ hệ thống thông tin. Sinh viên được đào tạo để trở thành các chuyên gia có khả năng thiết kế, triển khai và quản lý các giải pháp bảo mật thông tin hiệu quả.',
    'https://images.unsplash.com/photo-1550751827-4bd374c3f58b?w=400&h=250&fit=crop',
    '25.000.000 VNĐ/năm',
    '3.000 USD/năm',
    'Học phí có thể thay đổi theo quy định của Bộ Giáo dục và Đào tạo',
    '["Tốt nghiệp THPT hoặc tương đương", "Điểm chuẩn: 23-25 điểm (tùy năm)", "Tổ hợp xét tuyển: A00, A01, D01, D07", "Yêu cầu tiếng Anh: IELTS 5.5 hoặc tương đương", "Sức khỏe tốt, không mắc các bệnh truyền nhiễm"]',
    '["Giáo trình bảo mật thông tin", "Phần mềm mô phỏng tấn công mạng", "Tài liệu thực hành penetration testing", "Công cụ phân tích mã độc", "Tài liệu chuẩn bảo mật quốc tế"]',
    '["Chuyên gia bảo mật thông tin", "Penetration Tester", "Security Analyst", "Cybersecurity Consultant", "Security Architect", "Incident Response Specialist", "Digital Forensics Expert", "Security Operations Manager"]',
    '[{"id":"lo1","title":"LO1: Hiểu biết sâu sắc về các nguyên lý và kỹ thuật bảo mật thông tin.","content":"PI 1.1: Nắm vững lý thuyết mật mã học\\nPI 1.2: Hiểu các mối đe dọa và tấn công mạng\\nPI 1.3: Áp dụng các biện pháp bảo vệ thông tin."}]'
),
(
    'Lập trình nhúng và di động',
    '7480108',
    '4 năm',
    'Hà Nội',
    'Mùa thu',
    'Chương trình đào tạo chuyên sâu về phát triển ứng dụng di động và hệ thống nhúng. Sinh viên được trang bị kiến thức về lập trình mobile app, IoT, embedded systems và các công nghệ hiện đại trong lĩnh vực phát triển phần mềm di động.',
    'https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?w=400&h=250&fit=crop',
    '25.000.000 VNĐ/năm',
    '3.000 USD/năm',
    'Học phí có thể thay đổi theo quy định của Bộ Giáo dục và Đào tạo',
    '["Tốt nghiệp THPT hoặc tương đương", "Điểm chuẩn: 22-24 điểm (tùy năm)", "Tổ hợp xét tuyển: A00, A01, D01, D07", "Yêu cầu tiếng Anh: IELTS 5.5 hoặc tương đương", "Sức khỏe tốt, không mắc các bệnh truyền nhiễm"]',
    '["Giáo trình lập trình di động", "Phần mềm phát triển Android/iOS", "Kit phát triển IoT", "Tài liệu thực hành embedded systems", "Công cụ debug và testing"]',
    '["Mobile App Developer", "Embedded Systems Engineer", "IoT Developer", "Software Engineer", "Full-stack Mobile Developer", "UI/UX Designer", "Technical Lead", "Product Manager"]',
    '[{"id":"lo1","title":"LO1: Phát triển ứng dụng di động đa nền tảng.","content":"PI 1.1: Lập trình iOS và Android\\nPI 1.2: Sử dụng React Native, Flutter\\nPI 1.3: Tối ưu hóa hiệu suất ứng dụng."}]'
),
(
    'Công nghệ Internet vạn vật',
    '7480109',
    '4 năm',
    'Hà Nội',
    'Mùa thu',
    'Chương trình đào tạo về IoT, kết nối thiết bị và phát triển hệ thống thông minh. Sinh viên được trang bị kiến thức về cảm biến, mạng không dây, cloud computing và các ứng dụng IoT trong thực tế.',
    'https://intech-group.vn/uploads/noidung/images/iot.jpg',
    '25.000.000 VNĐ/năm',
    '3.000 USD/năm',
    'Học phí có thể thay đổi theo quy định của Bộ Giáo dục và Đào tạo',
    '["Tốt nghiệp THPT hoặc tương đương", "Điểm chuẩn: 22-24 điểm (tùy năm)", "Tổ hợp xét tuyển: A00, A01, D01, D07", "Yêu cầu tiếng Anh: IELTS 5.5 hoặc tương đương", "Sức khỏe tốt, không mắc các bệnh truyền nhiễm"]',
    '["Giáo trình IoT và cảm biến", "Kit phát triển IoT", "Phần mềm mô phỏng mạng", "Tài liệu thực hành cloud computing", "Công cụ phân tích dữ liệu IoT"]',
    '["IoT Engineer", "Embedded Systems Developer", "Network Engineer", "Data Analyst", "Cloud Solutions Architect", "Smart City Consultant", "Industrial IoT Specialist", "IoT Security Expert"]',
    '[{"id":"lo1","title":"LO1: Thiết kế và triển khai hệ thống IoT.","content":"PI 1.1: Kết nối và quản lý thiết bị IoT\\nPI 1.2: Xử lý dữ liệu cảm biến\\nPI 1.3: Phát triển ứng dụng IoT thông minh."}]'
);

-- Tạo index để tối ưu hiệu suất tìm kiếm
CREATE INDEX idx_training_program_code ON training_program(code);
CREATE INDEX idx_training_program_active ON training_program(is_active);
CREATE INDEX idx_training_program_name ON training_program(name); 