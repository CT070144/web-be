# TrainingProgram API Documentation

## Tổng quan
API này cung cấp các endpoint để quản lý chương trình đào tạo của Khoa Công nghệ thông tin.

## Base URL
```
http://localhost:8080/api/training-programs
```

## Các Endpoint

### 1. Lấy tất cả chương trình đào tạo
**GET** `/api/training-programs`

**Response:**
```json
{
  "result": [
    {
      "id": 1,
      "name": "Trí tuệ nhân tạo",
      "code": "7480107",
      "duration": "4 năm",
      "campus": "Hà Nội",
      "admissionPeriod": "Mùa thu",
      "overview": "...",
      "imageUrl": "https://...",
      "domesticTuition": "25.000.000 VNĐ/năm",
      "internationalTuition": "3.000 USD/năm",
      "tuitionNotes": "...",
      "requirements": ["Tốt nghiệp THPT...", "..."],
      "materials": ["Giáo trình...", "..."],
      "careers": ["Chuyên gia AI/ML Engineer", "..."],
      "outcomes": [
        {
          "id": "lo1",
          "title": "LO1: Nhận diện được vấn đề...",
          "content": "PI 1.1: Hiểu bài toán..."
        }
      ],
      "isActive": true,
      "createdAt": "2024-01-01T00:00:00",
      "updatedAt": "2024-01-01T00:00:00"
    }
  ]
}
```

### 2. Lấy thông tin chi tiết chương trình đào tạo theo ID
**GET** `/api/training-programs/{id}`

**Response:** Tương tự như trên nhưng chỉ trả về 1 object

### 3. Lấy thông tin chi tiết chương trình đào tạo theo mã ngành
**GET** `/api/training-programs/code/{code}`

**Response:** Tương tự như trên

### 4. Tìm kiếm chương trình đào tạo
**GET** `/api/training-programs/search?keyword={keyword}`

**Response:** Danh sách các chương trình đào tạo phù hợp với từ khóa

### 5. Tạo chương trình đào tạo mới
**POST** `/api/training-programs`

**Request Body:**
```json
{
  "name": "Tên chương trình",
  "code": "7480107",
  "duration": "4 năm",
  "campus": "Hà Nội",
  "admissionPeriod": "Mùa thu",
  "overview": "Mô tả tổng quan...",
  "imageUrl": "https://...",
  "domesticTuition": "25.000.000 VNĐ/năm",
  "internationalTuition": "3.000 USD/năm",
  "tuitionNotes": "Ghi chú về học phí",
  "requirements": ["Yêu cầu 1", "Yêu cầu 2"],
  "materials": ["Tài liệu 1", "Tài liệu 2"],
  "careers": ["Nghề nghiệp 1", "Nghề nghiệp 2"],
  "outcomes": [
    {
      "id": "lo1",
      "title": "Learning Outcome 1",
      "content": "Nội dung chi tiết"
    }
  ],
  "isActive": true
}
```

### 6. Cập nhật chương trình đào tạo
**PUT** `/api/training-programs/{id}`

**Request Body:** Tương tự như POST

### 7. Xóa chương trình đào tạo
**DELETE** `/api/training-programs/{id}`

### 8. Vô hiệu hóa chương trình đào tạo
**PUT** `/api/training-programs/{id}/deactivate`

## Cài đặt và chạy

### 1. Tạo bảng và dữ liệu mẫu
Chạy file SQL `training_program.sql` trong database của bạn:

```sql
-- Chạy toàn bộ nội dung file training_program.sql
```

### 2. Cấu hình database
Đảm bảo cấu hình database trong `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Chạy ứng dụng
```bash
mvn spring-boot:run
```

## Lưu ý
- Tất cả các endpoint đều trả về dữ liệu dưới dạng JSON
- Các trường `requirements`, `materials`, `careers` được lưu dưới dạng JSON string trong database
- Trường `outcomes` chứa thông tin về learning outcomes với cấu trúc phức tạp hơn
- API hỗ trợ CORS cho frontend
- Tất cả các chương trình đào tạo đều có trạng thái `isActive` để quản lý

## Error Handling
- 400 Bad Request: Dữ liệu đầu vào không hợp lệ
- 404 Not Found: Không tìm thấy chương trình đào tạo
- 500 Internal Server Error: Lỗi server

## Validation
- Mã ngành (`code`) phải là duy nhất
- Tên chương trình (`name`) không được để trống
- Mã ngành (`code`) không được để trống 