## Trả lời ngắn gọn khi phỏng vấn

**Comparable** là interface cho phép 1 class tự định nghĩa **thứ tự sắp xếp mặc định** (natural ordering) cho chính nó, thông qua method `compareTo(T o)`. Implement trực tiếp trong class, chỉ có **1** cách sort duy nhất.

**Comparator** là interface định nghĩa cách so sánh **từ bên ngoài** class, thông qua method `compare(T o1, T o2)`. Cho phép tạo **nhiều** cách sort khác nhau tùy ngữ cảnh, không cần sửa class gốc.

**Khác biệt chính:**
| | Comparable | Comparator |
|---|---|---|
| Method | `compareTo(o)` | `compare(o1, o2)` |
| Số cách sort | 1 (mặc định) | Nhiều |
| Sửa class gốc | Có | Không |
| Package | `java.lang` | `java.util` |

**Khi nào dùng cái nào:** `Comparable` khi object có 1 thứ tự tự nhiên rõ ràng (VD: `Integer` theo giá trị). `Comparator` khi cần sort linh hoạt theo nhiều tiêu chí, hoặc không sửa được source class (class từ thư viện ngoài).

Nếu phỏng vấn viên hỏi thêm, có thể nói thêm 1 câu về `TreeSet`/`TreeMap`: chúng cần 1 trong 2 cái này để biết cách sắp xếp/check trùng phần tử.