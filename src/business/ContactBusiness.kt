package business

import entity.ContactEntity
import repository.ContactRepository
import java.lang.Exception

class ContactBusiness {

    private fun validateDelete(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover.")
        }
    }

    private fun validate(name: String, phone: String) {
        if (name == "") {
            throw  Exception("Nome é obrigatório")
        }
        if (phone == "") {
            throw  Exception("Telefone é obrigatório")
        }
    }


    fun getContactDescripition(): String {
        val list = getList()
        return when {
            list.isEmpty() -> "0 contatos"
            list.size == 1 -> "1 contato"
            else -> "${list.size} contatos"
        }
    }

    fun save(nome: String, phone: String) {
        validate(nome, phone)
        val contact = ContactEntity(nome, phone)
        ContactRepository.save(contact)
    }

    fun delete(nome: String, phone: String) {
        validateDelete(nome, phone)

        val contact = ContactEntity(nome, phone)
        ContactRepository.delete(contact)
    }


    fun getList(): List<ContactEntity> {
        return ContactRepository.getList()
    }

}
