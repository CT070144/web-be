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

-- Tạo bảng subject
CREATE TABLE IF NOT EXISTS subject (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ten_mon VARCHAR(255) NOT NULL,
    ma_mon VARCHAR(50) NOT NULL UNIQUE,
    so_tin_chi INT,
    hoc_ky INT,
    mo_ta TEXT,
    category VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Tạo bảng trung gian training_program_subject
CREATE TABLE IF NOT EXISTS training_program_subject (
    training_program_id BIGINT,
    subject_id BIGINT,
    PRIMARY KEY (training_program_id, subject_id),
    FOREIGN KEY (training_program_id) REFERENCES training_program(id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject(id) ON DELETE CASCADE
);

-- Thêm dữ liệu mẫu cho training_program
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

-- Thêm dữ liệu mẫu cho subject
INSERT INTO subject (ten_mon, ma_mon, so_tin_chi, hoc_ky, mo_ta, category) VALUES
-- Môn học cơ sở chung
('Toán học rời rạc', 'MATH101', 3, 1, 'Cung cấp kiến thức cơ bản về logic, tập hợp, quan hệ và đồ thị', 'Cơ sở ngành'),
('Lập trình cơ bản', 'CS101', 4, 1, 'Giới thiệu về lập trình với ngôn ngữ Python', 'Cơ sở ngành'),
('Tiếng Anh cơ bản', 'ENG101', 2, 1, 'Rèn luyện kỹ năng tiếng Anh cơ bản', 'Giáo dục chuyên nghiệp'),
('Cấu trúc dữ liệu và giải thuật', 'CS201', 4, 2, 'Nghiên cứu các cấu trúc dữ liệu và thuật toán cơ bản', 'Cơ sở ngành'),
('Cơ sở dữ liệu', 'CS202', 3, 2, 'Thiết kế và quản lý cơ sở dữ liệu', 'Cơ sở ngành'),
('Lập trình hướng đối tượng', 'CS203', 3, 2, 'Phát triển ứng dụng theo mô hình hướng đối tượng', 'Cơ sở ngành'),
('Mạng máy tính', 'CS301', 3, 3, 'Kiến thức về mạng và truyền thông dữ liệu', 'Chuyên ngành'),
('Hệ điều hành', 'CS302', 3, 3, 'Nguyên lý hoạt động của hệ điều hành', 'Chuyên ngành'),
('Phát triển ứng dụng web', 'CS303', 4, 3, 'Xây dựng ứng dụng web với các công nghệ hiện đại', 'Chuyên ngành'),

-- Môn học chuyên ngành AI
('Trí tuệ nhân tạo', 'AI401', 4, 4, 'Giới thiệu về AI và machine learning', 'Chuyên ngành'),
('Xử lý ảnh số', 'AI402', 3, 4, 'Kỹ thuật xử lý và phân tích ảnh số', 'Chuyên ngành'),
('Học máy', 'AI403', 4, 4, 'Thuật toán và ứng dụng của machine learning', 'Chuyên ngành'),
('Deep Learning', 'AI501', 4, 5, 'Mạng nơ-ron sâu và ứng dụng', 'Chuyên ngành'),
('Xử lý ngôn ngữ tự nhiên', 'AI502', 3, 5, 'Kỹ thuật xử lý và hiểu ngôn ngữ tự nhiên', 'Chuyên ngành'),
('Computer Vision', 'AI503', 3, 5, 'Thị giác máy tính và nhận dạng hình ảnh', 'Chuyên ngành'),

-- Môn học chuyên ngành An toàn thông tin
('Mật mã học', 'SEC401', 4, 4, 'Lý thuyết và ứng dụng của mật mã học', 'Chuyên ngành'),
('An ninh mạng', 'SEC402', 3, 4, 'Bảo vệ hệ thống mạng khỏi các tấn công', 'Chuyên ngành'),
('Phân tích mã độc', 'SEC403', 4, 4, 'Kỹ thuật phân tích và phát hiện mã độc', 'Chuyên ngành'),
('Penetration Testing', 'SEC501', 4, 5, 'Kỹ thuật kiểm thử xâm nhập hệ thống', 'Chuyên ngành'),
('Digital Forensics', 'SEC502', 3, 5, 'Điều tra số và thu thập bằng chứng', 'Chuyên ngành'),
('Security Architecture', 'SEC503', 3, 5, 'Thiết kế kiến trúc bảo mật hệ thống', 'Chuyên ngành'),

-- Môn học chuyên ngành Mobile & Embedded
('Lập trình Android', 'MOB401', 4, 4, 'Phát triển ứng dụng di động Android', 'Chuyên ngành'),
('Lập trình iOS', 'MOB402', 3, 4, 'Phát triển ứng dụng di động iOS', 'Chuyên ngành'),
('React Native', 'MOB403', 4, 4, 'Phát triển ứng dụng đa nền tảng với React Native', 'Chuyên ngành'),
('Flutter', 'MOB501', 4, 5, 'Phát triển ứng dụng đa nền tảng với Flutter', 'Chuyên ngành'),
('Embedded Systems', 'MOB502', 3, 5, 'Lập trình hệ thống nhúng', 'Chuyên ngành'),
('IoT Development', 'MOB503', 3, 5, 'Phát triển ứng dụng Internet of Things', 'Chuyên ngành'),

-- Môn học chuyên ngành IoT
('Cảm biến và thiết bị IoT', 'IOT401', 4, 4, 'Nghiên cứu các loại cảm biến và thiết bị IoT', 'Chuyên ngành'),
('Mạng không dây', 'IOT402', 3, 4, 'Kỹ thuật mạng không dây cho IoT', 'Chuyên ngành'),
('Cloud Computing', 'IOT403', 4, 4, 'Điện toán đám mây và ứng dụng IoT', 'Chuyên ngành'),
('Big Data Analytics', 'IOT501', 4, 5, 'Phân tích dữ liệu lớn cho IoT', 'Chuyên ngành'),
('Smart City Applications', 'IOT502', 3, 5, 'Ứng dụng IoT trong thành phố thông minh', 'Chuyên ngành'),
('Industrial IoT', 'IOT503', 3, 5, 'IoT trong công nghiệp 4.0', 'Chuyên ngành'),

-- Môn học thực tập và đồ án
('Đồ án chuyên ngành', 'PROJ601', 6, 6, 'Thực hiện dự án chuyên ngành hoàn chỉnh', 'Thực tập'),
('Thực tập tốt nghiệp', 'INTERN602', 4, 6, 'Thực tập tại doanh nghiệp', 'Thực tập'),
('Khóa luận tốt nghiệp', 'THESIS603', 8, 6, 'Nghiên cứu và báo cáo tốt nghiệp', 'Thực tập');

-- Thêm quan hệ many-to-many giữa training_program và subject
-- Trí tuệ nhân tạo (ID 1) - Tất cả môn học cơ sở + môn học AI + thực tập
INSERT INTO training_program_subject (training_program_id, subject_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (1, 8), (1, 9), -- Cơ sở
(1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), -- AI
(1, 40), (1, 41), (1, 42); -- Thực tập

-- An toàn thông tin (ID 2) - Tất cả môn học cơ sở + môn học Security + thực tập
INSERT INTO training_program_subject (training_program_id, subject_id) VALUES
(2, 1), (2, 2), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (2, 8), (2, 9), -- Cơ sở
(2, 16), (2, 17), (2, 18), (2, 19), (2, 20), (2, 21), -- Security
(2, 40), (2, 41), (2, 42); -- Thực tập

-- Lập trình nhúng và di động (ID 3) - Tất cả môn học cơ sở + môn học Mobile + thực tập
INSERT INTO training_program_subject (training_program_id, subject_id) VALUES
(3, 1), (3, 2), (3, 3), (3, 4), (3, 5), (3, 6), (3, 7), (3, 8), (3, 9), -- Cơ sở
(3, 22), (3, 23), (3, 24), (3, 25), (3, 26), (3, 27), -- Mobile
(3, 40), (3, 41), (3, 42); -- Thực tập

-- Công nghệ Internet vạn vật (ID 4) - Tất cả môn học cơ sở + môn học IoT + thực tập
INSERT INTO training_program_subject (training_program_id, subject_id) VALUES
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5), (4, 6), (4, 7), (4, 8), (4, 9), -- Cơ sở
(4, 28), (4, 29), (4, 30), (4, 31), (4, 32), (4, 33), -- IoT
(4, 40), (4, 41), (4, 42); -- Thực tập

-- Tạo index để tối ưu hiệu suất tìm kiếm
CREATE INDEX idx_training_program_code ON training_program(code);
CREATE INDEX idx_training_program_active ON training_program(is_active);
CREATE INDEX idx_training_program_name ON training_program(name);
CREATE INDEX idx_subject_ma_mon ON subject(ma_mon);
CREATE INDEX idx_subject_hoc_ky ON subject(hoc_ky);
CREATE INDEX idx_training_program_subject_program ON training_program_subject(training_program_id);
CREATE INDEX idx_training_program_subject_subject ON training_program_subject(subject_id); 