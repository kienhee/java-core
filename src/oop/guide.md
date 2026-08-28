## OOP trong Java — Tổng quan

### 1. 4 tính chất cốt lõi (Pillars)

**a) Encapsulation (Đóng gói)**
- Giấu chi tiết implementation, chỉ expose ra ngoài thông qua interface/method công khai
- Thực hiện bằng: field `private` + `getter`/`setter` (hoặc chỉ getter nếu muốn immutable)
```java
public class User {
    private String email; // không cho truy cập trực tiếp
    
    public String getEmail() { return email; }
    public void setEmail(String email) {
        if (!email.contains("@")) throw new IllegalArgumentException("Invalid email");
        this.email = email;
    }
}
```
**Giải quyết:** bảo vệ tính toàn vẹn dữ liệu (validate trước khi set), giảm coupling — bên ngoài không cần biết field lưu trữ thế nào, chỉ cần biết method nào để gọi.

---

**b) Inheritance (Kế thừa)**
- Class con (`subclass`) kế thừa field/method từ class cha (`superclass`) qua `extends`
- Tái sử dụng code, tạo quan hệ "is-a" (`Dog extends Animal` → Dog **là một** Animal)
```java
class Animal {
    protected String name;
    void eat() { System.out.println(name + " is eating"); }
}
class Dog extends Animal {
    void bark() { System.out.println(name + " is barking"); }
}
```
- Java chỉ hỗ trợ **single inheritance** (1 class chỉ extends được 1 class cha) — tránh Diamond Problem. Muốn "đa kế thừa" behavior thì dùng `interface`.

---

**c) Polymorphism (Đa hình)**
Có 2 loại:

- **Compile-time (Method Overloading)**: cùng tên method, khác tham số (số lượng/kiểu)
```java
void print(int x) {}
void print(String x) {}
```

- **Runtime (Method Overriding)**: class con định nghĩa lại method của class cha, JVM quyết định gọi version nào **lúc chạy** dựa trên object thực tế (không phải kiểu khai báo)
```java
Animal a = new Dog(); // khai báo kiểu Animal, nhưng object thực tế là Dog
a.makeSound(); // gọi version của Dog, không phải Animal
```
**Cơ chế đứng sau:** dynamic method dispatch — mỗi object có 1 bảng vtable trỏ đến method thực tế của class nó thuộc về.

**Ứng dụng thực tế:** đây là nền tảng của Dependency Injection trong Spring — bạn code theo interface (`UserRepository`), Spring inject implementation cụ thể (`UserRepositoryImpl` hay `JpaUserRepository`) lúc runtime.

---

**d) Abstraction (Trừu tượng hóa)**
- Chỉ định nghĩa **cái gì** (what) cần làm, giấu đi **làm như thế nào** (how)
- Thực hiện qua `abstract class` hoặc `interface`

```java
interface PaymentService {
    void pay(double amount); // chỉ khai báo, không có implementation
}
class MomoPayment implements PaymentService {
    public void pay(double amount) { /* logic riêng */ }
}
```

---

### 2. `abstract class` vs `interface`

| | Abstract Class | Interface |
|---|---|---|
| Kế thừa | 1 class chỉ extends 1 abstract class | 1 class implements **nhiều** interface |
| Constructor | Có | Không |
| Field | Có thể có field thường (state) | Chỉ `static final` (constant) |
| Method | Có thể có method đã implement + abstract method | Từ Java 8: có `default`/`static` method, còn lại là abstract |
| Dùng khi | Các subclass có chung state/behavior cốt lõi ("is-a" chặt) | Định nghĩa **capability/contract** ("can-do") |

**Ví dụ khi nào chọn cái nào:**
- `abstract class Animal` — Dog, Cat đều **là** Animal, chia sẻ field `name`, `age`
- `interface Comparable`, `interface Flyable` — không phải quan hệ "is-a", mà là "có khả năng làm gì"

---

### 3. Composition over Inheritance

Best practice hiện đại: ưu tiên **composition** (has-a) hơn **inheritance** (is-a) khi có thể, vì inheritance tạo coupling chặt (class con phụ thuộc chi tiết implementation của class cha, thay đổi class cha dễ vỡ class con — gọi là "fragile base class problem").

```java
// Inheritance (tight coupling)
class ElectricCar extends Car { }

// Composition (loose coupling, linh hoạt hơn)
class Car {
    private Engine engine; // has-a, không phải is-a
    Car(Engine engine) { this.engine = engine; }
}
```

Đây cũng chính là tư tưởng đứng sau Dependency Injection trong Spring — inject dependency (has-a) thay vì extends.

---

### 4. SOLID — nguyên tắc thiết kế OOP (liên quan trực tiếp đến RBAC blog của bạn)

- **S**ingle Responsibility — 1 class chỉ nên có 1 lý do để thay đổi
- **O**pen/Closed — mở để extend, đóng để modify (dùng interface/abstraction để thêm behavior mới mà không sửa code cũ)
- **L**iskov Substitution — class con phải thay thế được class cha mà không phá vỡ logic chương trình
- **I**nterface Segregation — nhiều interface nhỏ, chuyên biệt, tốt hơn 1 interface lớn ôm đồm
- **D**ependency Inversion — phụ thuộc vào abstraction (interface), không phụ thuộc vào implementation cụ thể → nền tảng của Spring DI/IoC

---

### 5. Điểm hay bị hỏi thêm khi phỏng vấn

- **`this` vs `super`**: `this` trỏ đến object hiện tại, `super` trỏ đến class cha (gọi constructor/method của cha)
- **Constructor có được kế thừa không?** Không — nhưng class con phải gọi `super()` (ngầm định hoặc tường minh) để khởi tạo phần của class cha trước
- **Overloading vs Overriding**: Overloading = cùng class, khác signature, resolve lúc compile-time. Overriding = khác class (cha-con), cùng signature, resolve lúc runtime
- **`final` trong OOP**: `final class` = không cho kế thừa, `final method` = không cho override, `final field` = không cho gán lại sau khi khởi tạo